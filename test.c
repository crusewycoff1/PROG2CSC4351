fun int main() {
    var int result = 1;
    var int base = 2;
    var int exp = 3;
    var int i = 0;

    for (i = 0; i < exp; i++) {
        result *= base;
    }

    var int count = 0;
    while (count < 5) {
        count++;
    }

    var int doCount = 0;
    do {
        doCount++;
    } while (doCount < 5);

    if (result > 10) {
        result = 10;
    } else {
        result = 5;
    }

    fun int add(var int a, var int b) {
        return a + b;
    }
    var int sum = add(3, 4);

    var int x = 10;
    var int y = 20;

    x = y;

    var int neg = -x;

    var int sum2 = x + y;

    struct Point {
        var int x;
        var int y;
    };
    struct Point p;
    p.x = 1;
    p.y = 2;

    return 0;
}