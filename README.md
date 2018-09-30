# positioncalculator

ABC Investment Bank is a prominent global bank, as part of the General Ledger System, you are required to develop a position calculation process.
Position Calculation process takes start of day positions and transaction files as input, apply transactions on positions based on transaction type (B/S) and account type (I/E), and computes end of day positions. Depending on the direction of the transaction (Buy/Sell) each transaction is recorded as debit and credit into external and internal accounts in the “Positions” file.
</br>
</br>
Input:</br>
Positions File: contain start positions for instruments</br>
Transactions Files: contains transactions for a day</br>
</br></br>
<pre>
Process:
Read Positions and Transactions files, compute new positions and write to new end of day positions file.
For each transaction in Transaction file,
Apply TransactionQuantity into matching instrument records in the position file
If Transaction Type =B ,
                                For AccountType=E, Quantity=Quantity + TransactionQuantity
                                For AccountType=I, Quantity=Quantity - TransactionQuantity
If Transaction Type =S ,
                                For AccountType=E, Quantity=Quantity - TransactionQuantity
                                For AccountType=I, Quantity=Quantity + TransactionQuantity
</pre>                                

<a href="https://github.com/vipul05tiwari/positioncalculator/tree/master/src/main/resources">Sample</a> Position, Transaction and EOD Position File
