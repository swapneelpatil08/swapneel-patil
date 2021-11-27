# swapneel-patil

# Charter

## Coverage
### Platform
 - iOS
    - Model: iPhone 11
    - iOS version: 15.0.2

## Testing
### Target
This test will carry out the testing related to addition of various  income and various expenses. 

### Test data:
    - Add income amount INR 120,000.
        - Category: Salary
        - Payment mode: Card
    - Add below expenses:
        - Category Bill: INR 1000/- Notes: Broadband bill, Payment mode: Card
        - Category Bill: INR 700/- Notes: Telephone bill, Payment mode: Cash
        - Category Bill: INR 800/- Notes: Electricity bill, Payment mode: Card
        - Category Rent: INR 20,000/- Notes: House rent, Payment mode: Cash
        - Category Car: INR 15,000/- Notes: Car EMI, Payment mode: Cash
        - Category Car: INR 15,000/- Notes: Fuel, Payment mode: Card

### Tests:
- All buttons are clickable. 
- Buttons/icons should not be overlapping. 
- With the above data setup:
> Verification on Dashboard:
> - Should show total of income (INR 120,000) and expense (INR 41,500) in centre.
> - Should show correct expense percentage (aggreagate to nearest whole number) in all respective categories . (Car: 46%, House: 48% Bills: 6%)
> - Should show correct views on dashboard
>   - Centre expense pie chart should display in expenses in various colours with respective category percentage.
>   - Should display balance amount (income - expense)

- Apply filters: 
    - By Cash or By Card
> Verification on Dashboard:
> - Should update the dashboard.
> - Should only display the trasactions made by payment mode cash.
> - Should udpate expense category percentage.
> - should update balance amount correctly.

- Export to file from settings:
> Verification in exported file:
> - Should contain all the income and expenses.
> - Should be sorted in ascending date.
> - Negative scenario: Report is not corrupted.

- Add new expense which is not present on dashboard currently. (Transafer pay - Cash to Card)
> Verification on Dashboard - Apply filter - All accounts:
> - Should not chnage any thing on dashboard.
> Verification on dashboard - Apply filter - By cash.
> - Should show new expense category - Transfer.
> Verification on dashboard - Apply filter - By card.
> - Should not show new expense category - Transfer.
> - Click on Balance to see the details, there should be new entry Transfer from Cash. 

## Duration
2 hours.

## Tester Name
Swapneel Patil

## Bugs
No Bugs found.

## Issues
No open issues.
