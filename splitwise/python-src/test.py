import json
from core import Splitwise

with open("../cases.json") as f:
    test_cases = json.load(f)

for case in test_cases:
    s = Splitwise()
    for entry in case["input"]:
        s.add_spending(entry["name"], entry["amount"])

    spending = s.show_spending()
    settlements = s.get_settlements()

    print(f"Test: {case['name']}")
    print("Spending:", spending)
    print("Expected:", case["expected"]["spending"])
    print("Settlements:", settlements)
    print("Expected Settlements:", case["expected"]["settlements"])
    print()
