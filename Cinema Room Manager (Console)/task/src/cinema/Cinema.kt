package cinema
const val FTICKETS = 10
const val BTICKETS = 8
const val MAX = 60

fun show(seats: Int, rows: Int, row: MutableList<Int>, seat: MutableList<Int>) {
    println("Cinema:")
    for (s in 1..seats) {
        print(" $s")
    }
    println()
    for (r in 1..rows) {
        print(r)
        for (s in 1..seats) {
            if (r in row && s in seat) {
                print(" B")
            } else {
                print(" S")
            }   
        }
        println()
    }
}

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val total = rows * seats

    var row: MutableList<Int> = mutableListOf()
    var seat: MutableList<Int> = mutableListOf()
    var currentIncome = 0
    var op = -1
    var totalIncome = 0
    var bHalf:Int = 0
    var fHalf:Int = 0

    while (op != 0) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        op = readln().toInt()

        if (op == 1){
            show(seats, rows, row, seat)
        }

        if (op == 2) {
            while(true) {
                println("Enter a row number:")
                var r = readln().toInt()
                println("Enter a seat number in that row:")
                var s = readln().toInt()
                if((s in seat && r in row) && (seat.indexOf(s) == row.indexOf(r))) {
                    println("That ticket has already been purchased!")
                    println("Ticket price:")
                } else if(r > rows || s > seats) {
                    println("Wrong input!")
                    println("Ticket price:")
                } else {    
                    seat.add(s)
                    row.add(r)
                    var ticket = 0

                    if (total <= MAX) {
                    ticket = 10
                    } else {
                        if (row.last() <= rows/2) {
                            ticket = 10
                        } else {
                            ticket = 8
                        }
                    }
                    currentIncome += ticket
                    println("Ticket price: \$$ticket")
                    break
                }     
            }
        }

        if (op == 3) {
            if (total <= MAX) {
                totalIncome = total * FTICKETS 
            } else {
                bHalf = ((rows/2)+(rows%2))*seats
                fHalf = ((rows/2))* seats
                totalIncome = fHalf * FTICKETS + bHalf * BTICKETS
            }

            println("Number of purchased tickets: ${row.size}")
            var percentage: Double = (seat.size * 100).toDouble() / (rows * seats).toDouble()
            var formatPercentage = "%.2f".format(percentage)
            println("Percentage: $formatPercentage%")
            println("Current income: \$$currentIncome")
            println("Total income: \$$totalIncome")

        }
    }
}