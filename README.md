# eComm for Boring Inc: Profit Margin Calculator

[Repository Link](https://github.com/AndNijaz/eComm-for-Boring-Inc)

## Project Description
The eComm for Boring Inc project calculates profit margins for orders processed through an eCommerce platform. This application analyzes order data provided in CSV format and generates key financial reports such as total revenue, total profit, profit per shirt size, and more. The solution uses multithreading to enhance performance and implements the Strategy pattern for payment processing.

---

## Objectives
The main objectives of this project are:
1. Calculate the total revenue of eComm.
2. Determine the total profit of eComm.
3. Analyze profit distribution across different shirt sizes.
4. Implement payment processing using the Strategy pattern.
5. Optimize report generation using multithreading.

---

## Features
- **Profit Margin Calculation**: Calculates profit margins based on product and payment configurations.
- **Threaded Report Generation**: Uses multithreading for efficient data processing.
- **Payment Strategy Pattern**: Implements a flexible payment system based on customer payment methods.
- **Detailed Reporting**: Generates revenue, profit, and size-based profitability insights.

---

## Data Format
### Input File
The CSV file format is as follows:
```
full_name,shirt_size,with_design,with_hoodie,payment
```
#### Columns:
- **full_name**: Name of the customer.
- **shirt_size**: Size of the shirt (e.g., S, M, L, XL).
- **with_design**: Boolean indicating if a design is applied.
- **with_hoodie**: Boolean indicating if a hoodie is included.
- **payment**: Payment method (e.g., wallet, visa, mastercard).

---

## Pricing Details
1. **Base Price**: Customers pay 40 BAM per shirt.
2. **Supplier Costs**:
   - Shirt: 14 BAM.
   - Hoodie: +3 BAM.
   - Design: +2 BAM.
3. **Payment Processing Fees**:
   - **Wallet**: No additional cost.
   - **Bankcard**: 5% of transaction.
   - **Visa**: 2% of transaction.
   - **Mastercard**: 3% of transaction.
   - **Other Methods**: 10% of transaction.

---

## Implementation Details
### Technologies Used
- **Java**: Core language for processing and analysis.
- **Design Patterns**: Strategy pattern for payment processing.

### Process
1. **Data Loading**:
   - Read the CSV file
   - Validate and preprocess data.
2. **Payment Strategy Implementation**:
   - Define strategies for different payment methods.
   - Calculate fees dynamically based on the payment method.
3. **Profit Margin Calculation**:
   - Compute revenue and profit for each order.
   - Aggregate results by shirt size and overall metrics.
4. **Multithreaded Report Generation**:
   - Use threads to generate different reports concurrently.
5. **Output Reports**:
   - Summarize total revenue, total profit, and size-based profits.

---

## Usage

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/AndNijaz/eComm-for-Boring-Inc.git
   ```
2. Navigate to the project directory:
   ```bash
   cd eComm-for-Boring-Inc
   ```
3. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```
4. Run the application:
   ```bash
   python main.py customer_orders.csv
   ```

### Output
- **Total Revenue**: Overall revenue generated by eComm.
- **Total Profit**: Net profit after deducting costs and fees.
- **Profit Per Shirt Size**: Profitability analysis based on shirt sizes.
- **Log File**: Detailed breakdown of calculations and processing steps.

---

## Challenges and Reflections
### Challenges
- Implementing multithreading while ensuring data consistency.
- Dynamically applying payment fees based on varied methods.

### Improvements
- Implement logging for debugging and tracking issues.
- Optimize data loading for larger CSV files.

---
