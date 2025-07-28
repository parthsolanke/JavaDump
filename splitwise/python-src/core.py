from collections import defaultdict

class Splitwise:
    def __init__(self):
        self.spending = defaultdict(float)

    def add_spending(self, name, amount):
        self.spending[name] += amount

    def show_spending(self):
        return {name: round(amount, 2) for name, amount in self.spending.items()}

    def _compute_net(self):
        total = sum(self.spending.values())
        n = len(self.spending)
        share = total / n
        return {name: round(amount - share, 2) for name, amount in self.spending.items()}

    def _get_creditors_debitors(self):
        creditors, debitors = [], []
        net_balances = self._compute_net()
        for person, amount in net_balances.items():
            if amount > 0:
                creditors.append([person, amount])
            elif amount < 0:
                debitors.append([person, -amount])
        return creditors, debitors

    def get_settlements(self):
        creditors, debitors = self._get_creditors_debitors()
        cred_idx = deb_idx = 0
        settlements = []

        while cred_idx < len(creditors) and deb_idx < len(debitors):
            deb_p, deb_amt = debitors[deb_idx]
            cred_p, cred_amt = creditors[cred_idx]

            settlement_amt = min(deb_amt, cred_amt)
            settlements.append(f"{deb_p} -> {cred_p}: ${settlement_amt:.2f}")

            debitors[deb_idx][1] -= settlement_amt
            creditors[cred_idx][1] -= settlement_amt

            if debitors[deb_idx][1] == 0:
                deb_idx += 1
            if creditors[cred_idx][1] == 0:
                cred_idx += 1

        return settlements
