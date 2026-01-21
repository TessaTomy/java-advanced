# ☕ _Java Core Foundations: Architectural Perspective_

## 1. The Java Execution Model

Java uses a hybrid compilation-interpretation approach to achieve "Write Once, Run Anywhere."

* **Compilation:** `Source.java`  `Source.class` (**Bytecode**).
* **Execution:** The **JVM (Java Virtual Machine)** interprets or JIT-compiles the bytecode into machine-specific instructions.
* **Key Concept:** **Platform Independence.** The bytecode remains identical across OSs; only the JVM implementation varies.

---

## 2. Anatomy of the Entry Point: `public static void main`

The JVM requires this exact signature to launch an application:

* **`public`**: The JVM (an external process) must have access. `private` or `protected` would hide the entry point from the launcher.
* **`static`**: Allows the JVM to call the method **without instantiating the class**. This avoids a "chicken and egg" scenario where you'd need an object to run the method that creates objects.
* **`void`**: Java manages program exit status via `System.exit()`, so no return value is needed.
* **`String[] args`**: Standardizes how command-line parameters are passed into the program.

---

## 3. Static vs. Instance (Non-Static)

This distinction determines how memory is allocated and how data is shared.

```java
class Player {
    static int playerCount = 0; // Shared by ALL instances (Class Level)
    String username;            // Unique to each instance (Object Level)

    Player(String username) {
        this.username = username;
        playerCount++; // Increment the global counter
    }

    // Static method: Can only access static members
    static void displayTotalPlayers() {
        System.out.println("Total Players: " + playerCount);
        // System.out.println(username); // ERROR: Static cannot see instance variables
    }

    // Instance method: Can access both static and instance members
    void showProfile() {
        System.out.println("User: " + username + " | Global Rank amongst " + playerCount);
    }
}

```

---

## 4. Memory Management: Stack vs. Heap

| Feature | **Stack** | **Heap** |
| --- | --- | --- |
| **Storage** | Primitive types and **References** (variable names). | All **Objects** (created with `new`). |
| **Lifetime** | Lives only as long as the current method scope. | Lives until the **Garbage Collector** removes it. |
| **Access** | Extremely fast. | Slower, but significantly larger. |

---

## 5. Access Specifiers (Visibility Control)

* **`private`**: Visible only within the same class. Best for data hiding.
* **`default`**: (No keyword) Visible only to classes in the same package.
* **`protected`**: Visible to the package and all subclasses (even in different packages).
* **`public`**: Visible to any class in any package.

---

## 6. Important Keywords

* **`this`**: A reference to the **current object instance**. Essential for resolving naming conflicts:
```java
void setAge(int age) {
    this.age = age; // 'this.age' is the class field, 'age' is the local parameter
}

```


* **`native`**: Signals that a method is implemented in C or C++. Used for low-level system interaction.
* **`synchronized`**: Used in multi-threading to ensure only one thread can access a resource at a time, preventing data race conditions.

---

## 7. The `Object` Class & String Pool

* **The Root**: Every class implicitly `extends java.lang.Object`. This provides methods like `equals()`, `hashCode()`, and `toString()`.
* **The String Trap**:
* `String s1 = "Hello";` (Lives in the **String Constant Pool**).
* `String s2 = new String("Hello");` (Lives in the general **Heap**).
* **Rule:** Always use `.equals()` for content comparison. `==` only compares memory addresses.



---

## 8. Input/Output (I/O) Mechanics

Java handles I/O through **Streams**. `System.out` is a `PrintStream`, and `System.in` is a `BufferedInputStream`.

**The Scanner Buffer Issue:**

```java
Scanner sc = new Scanner(System.in);
int id = sc.nextInt();     // Reads the number but leaves the "\n" (newline) in the buffer
sc.nextLine();             // CRITICAL: Consume the leftover newline
String name = sc.nextLine(); // Now this correctly waits for user input

```

---

## 9. The `final` Keyword: Restricting Change

In Java, `final` is used to make entities immutable or non-extensible. Its behavior changes depending on where it is applied:

### A. Final Variables (Constants)

Once assigned, the value cannot be changed.

```java
final int MAX_SPEED = 120;
// MAX_SPEED = 150; // COMPILER ERROR

```

### B. Final Methods (Prevent Overriding)

A subclass cannot override a final method. Use this to protect core logic that should never be altered by "child" classes.

```java
class Security {
    final void checkAccess() {
        System.out.println("Verifying identity...");
    }
}

```

### C. Final Classes (Prevent Inheritance)

A final class cannot be extended (inherited).

```java
final class Engine { ... }
// class TurboEngine extends Engine { } // ERROR: Cannot inherit from final class

```

> **Note:** The `String` class in Java is `final` for security and performance reasons.

---

## 10. The `abstract` Keyword: The Blueprint

`abstract` is the opposite of `final`. It forces inheritance and mandates that subclasses provide implementation.

### A. Abstract Methods

These methods have no body. They represent a "contract" that the subclass **must** fulfill.

```java
abstract void calculateTax(); // No { } implementation here

```

### B. Abstract Classes

A class that cannot be instantiated (you cannot do `new Shape()`). It exists only to be a base for other classes.

* If a class has at least one `abstract` method, the **entire class must be declared abstract**.

### C. Abstract vs. Variables?

* **Important:** There is **no such thing as an abstract variable**. Variables can be `static` or `final`, but they cannot be `abstract` because they must hold data, not a "definition" of data.

---

## 🏗️ Summary Comparison Table

| Keyword | On a Variable | On a Method | On a Class |
| --- | --- | --- | --- |
| **`final`** | Value becomes constant. | Cannot be overridden. | Cannot be inherited. |
| **`abstract`** | *(Not allowed)* | Has no body; must be overridden. | Cannot be instantiated. |
| **`static`** | Shared by all objects. | Belongs to class; call via `Class.name()`. | *(Only for nested classes)* |

---


