def sum(a, b) {
    echo "The sum of ${a} and ${b} is ${a + b}"
}

def sub(a, b) {
    echo "The difference between ${a} and ${b} is ${a - b}"
}

def multi(a, b) {
    echo "The product of ${a} and ${b} is ${a * b}"
}

def div(a, b) {
    if (b == 0) {
        echo "Division by zero is not allowed"
    } else {
        echo "The division of ${a} by ${b} is ${a / b}"
    }
}
