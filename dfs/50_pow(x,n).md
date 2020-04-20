### 1. 递归

思路：

* "求x的n次方" 的子问题为 "求x * x的n/2" 次方，例如power(4, 2) = power(16, 1)
* 需要注意的是，若n为偶数，那么递归到最后n一定是1；且当n为奇数时，n/2这个运算会丢失值，例如：3/2 == 1，因此我们需要进行一些特殊处理，
* 除此以外，我们需要明确一些边界条件：
  1. 当n为负数时，我们求的是 1/x^n
  2. 当n为0时，x^0 == 1

时间复杂度：O(logN)

空间复杂度：O(1)

```java
// 1ms
public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n < 0) {
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, -n/2);
        } else {
            return myPow(1/x, -n);
        }
    }
    if (n%2 == 0) {
        return myPow(x*x, n/2);
    } else {
        return x * myPow(x*x, n/2);
    }
}
```

```python
# 36ms
def myPow(self, x: float, n: int) -> float:
    if n == 0: return 1
    if n < 0: return self.myPow(1/x, -n)
    if n%2 == 0:
        return self.myPow(x*x, n//2)
    else:
        return self.myPow(x*x, n//2) * x
```