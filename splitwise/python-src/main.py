# python13
from core import Splitwise

def show_menu():
    print("\n--- Splitwise Menu ---")
    print("1. Add Expense")
    print("2. Show All Spendings")
    print("3. Show Balances")
    print("4. Show Settlements")
    print("5. Exit")


def main():
    splitwise = Splitwise()
    while True:
        show_menu()
        choice = input("Enter your choice (1-5): ")

        match choice:
            case "1":
                name = input("Enter the name: ").strip()
                try:
                    amount = float(input("Enter the amount spent: "))
                    splitwise.add_spending(name, amount)
                    print("Expense added successfully!")
                except ValueError:
                    print("Invalid amount. Please enter a number.")

            case "2":
                spendings = splitwise.show_spending()
                if not spendings:
                    print("No expenses recorded yet.")
                else:
                    print("\n--- Spending Summary ---")
                    for name, amt in spendings.items():
                        print(f"{name}: ${amt:.2f}")

            case "3":
                balances = splitwise._compute_net()
                if not balances:
                    print("No data to calculate balances.")
                else:
                    print("\n--- Net Balances ---")
                    for name, balance in balances.items():
                        print(f"{name}: {'owes' if balance < 0 else 'is owed'} ${abs(balance):.2f}")

            case "4":
                settlements = splitwise.get_settlements()
                if not settlements:
                    print("No settlements needed.")
                else:
                    print("\n--- Settlements ---")
                    for line in settlements:
                        print(line)

            case "5":
                print("Exiting. Goodbye!")
                break

            case _:
                print("Invalid choice. Please enter a number from 1 to 5.")


if __name__ == "__main__":
    main()
