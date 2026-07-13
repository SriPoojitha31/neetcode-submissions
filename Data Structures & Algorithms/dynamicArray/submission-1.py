class DynamicArray:
    def __init__(self, capacity):
        if capacity <= 0:
            raise ValueError("Capacity must be greater than 0")
        self.capacity = capacity
        self.size = 0
        self.data = [None] * capacity

    def get(self, i):
        if i < 0 or i >= self.size:
            raise IndexError("Index out of bounds")
        return self.data[i]

    def set(self, i, n):
        if i < 0 or i >= self.size:
            raise IndexError("Index out of bounds")
        self.data[i] = n

    def pushback(self, n):
        if self.size == self.capacity:
            self.resize()
        self.data[self.size] = n
        self.size += 1

    def popback(self):
        if self.size == 0:
            raise IndexError("Cannot pop from an empty array")
        value = self.data[self.size - 1]
        self.size -= 1
        return value

    def resize(self):
        self.capacity *= 2
        new_data = [None] * self.capacity
        for i in range(self.size):
            new_data[i] = self.data[i]
        self.data = new_data

    def getSize(self):
        return self.size

    def getCapacity(self):
        return self.capacity

# Example Usage
if __name__ == "__main__":
    # Initialize the array with capacity 1
    array = DynamicArray(1)

    # Check size and capacity
    print("Size:", array.getSize())  # Output: 0
    print("Capacity:", array.getCapacity())  # Output: 1

    # Push back elements
    array.pushback(1)
    print("Size after pushback:", array.getSize())  # Output: 1
    print("Capacity after pushback:", array.getCapacity())  # Output: 1

    array.pushback(2)
    print("Size after second pushback:", array.getSize())  # Output: 2
    print("Capacity after resize:", array.getCapacity())  # Output: 2

    # Access and modify elements
    print("Element at index 1:", array.get(1))  # Output: 2
    array.set(1, 3)
    print("Element at index 1 after set:", array.get(1))  # Output: 3

    # Pop back elements
    print("Popped element:", array.popback())  # Output: 3
    print("Size after popback:", array.getSize())  # Output: 1
