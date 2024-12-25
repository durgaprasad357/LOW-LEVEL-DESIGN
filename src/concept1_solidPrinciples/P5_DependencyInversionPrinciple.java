/*
    D - Dependency Inversion Principle
        A class should dependent on interface rather than concrete class.
*/

import helperInterfaces.KeyBoard;
import helperInterfaces.Mouse;

/*
class WiredKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("WiredKeyBoard Typing!.");
    }
}

class WiredMouse implements Mouse {
    @Override
    public void rightClick() {
        System.out.println("WiredMouse rightClick.");
    }

    @Override
    public void leftClick() {
        System.out.println("WiredMouse leftClick.");
    }

    @Override
    public void scrollUp() {
        System.out.println("WiredMouse scroolUp.");
    }

    @Override
    public void scrollDown() {
        System.out.println("WiredMouse scroolDown.");
    }
}

class MacBook {
    private final WiredKeyBoard keyBoard;
    private final WiredMouse mouse;

    public MacBook(WiredKeyBoard keyBoard, WiredMouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }

    public void typeSomething() {
        this.keyBoard.type();
    }

    public void pageUp() {
        this.mouse.scrollDown();
    }
}

public class P5_DependencyInversionPrinciple {
    public static void main(String args[]) {
        MacBook macBook = new MacBook(new WiredKeyBoard(), new WiredMouse());
        macBook.typeSomething();
        macBook.pageUp();
    }
}
*/

/*
    The above MacBook class is violating the DIP.
        - We have defined keyBoard and mouse as Wired(concrete classes), if I want to use MacBook with a wireless keyBoard and Mouse,
          I am not able to use them because we have defined concrete classes for keyBoard and Mouse.

    After convetring MacBook to DIP: Below code.
    1. **Abstraction over Concrete Classes**: 
        - The `MacBook` class previously depended on concrete implementations of `WiredKeyBoard` and `WiredMouse`. 
        - To follow DIP, we introduced interfaces `KeyBoard` and `Mouse`, making `MacBook` depend on these abstractions instead of concrete classes.
*/

class WiredKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("WiredKeyBoard Typing!.");
    }
}

class WirelessKeyBoard implements KeyBoard {
    @Override
    public void type() {
        System.out.println("WirelessKeyBoard Typing!.");
    }
}

class WiredMouse implements Mouse {
    @Override
    public void rightClick() {
        System.out.println("WiredMouse rightClick.");
    }

    @Override
    public void leftClick() {
        System.out.println("WiredMouse leftClick.");
    }

    @Override
    public void scrollUp() {
        System.out.println("WiredMouse scrollUp.");
    }

    @Override
    public void scrollDown() {
        System.out.println("WiredMouse scrollDown.");
    }
}

class WirelessMouse implements Mouse {
    @Override
    public void rightClick() {
        System.out.println("WirelessMouse rightClick.");
    }

    @Override
    public void leftClick() {
        System.out.println("WirelessMouse leftClick.");
    }

    @Override
    public void scrollUp() {
        System.out.println("WirelessMouse scrollUp.");
    }

    @Override
    public void scrollDown() {
        System.out.println("WirelessMouse scrollDown.");
    }
}

class MacBook {
    private final KeyBoard keyBoard;
    private final Mouse mouse;

    public MacBook(KeyBoard keyBoard, Mouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }

    public void typeSomething() {
        this.keyBoard.type();
    }

    public void pageUp() {
        this.mouse.scrollDown();
    }
}

public class P5_DependencyInversionPrinciple {
    public static void main(String[] args) {
        WiredKeyBoard wiredKeyBoard = new WiredKeyBoard();
        WirelessKeyBoard wirelessKeyBoard = new WirelessKeyBoard();

        WiredMouse wiredMouse = new WiredMouse();
        WirelessMouse wirelessMouse = new WirelessMouse();

        MacBook macBook1 = new MacBook(wiredKeyBoard, wiredMouse);
        macBook1.typeSomething();
        macBook1.pageUp();

        MacBook macBook2 = new MacBook(wirelessKeyBoard, wirelessMouse);
        macBook2.typeSomething();
        macBook2.pageUp();
    }
}
