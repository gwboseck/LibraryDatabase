#Library Database

This project involved implementing singleton, state, and observer design patterns in Java. The end goal was to have a program
that simulated how some of the back end functions in an actual library database might work. Books have a state (On the shelf,
out on loan, returned and waiting to be shelved) and a tesing class would attempt to call certain methods on the book. For
example, a book that is on the shelf can't be returned, so how is that handled in code? 

The "meat" of the program is the LibraryBook class which is implemented as a State class as part of a State design pattern. It
knows its current state and what methods can be called on it, but how those methods are implemented is left to the Concrete
State subclasses (OnLoan, Returned, and Shelved), and the program behaves according to its current state and the method being
called on it. If a LibraryBook object is in the Shelved state and we attempt to call the `borrow()` method, then the
LibraryBook class calls the Shelved classes version of `borrow()` which would change the state of the LibraryBook object from
Shelved to OnLoan. If we tried that same `borrow()` call on a LibraryBook object in the OnLoan state, we would instead throw a
`NotAllowedException`. 

The DatabaseManager class, and the OnLoan, Returned, and Shelved subclasses are implemented as singletons, making them
globally accessible, and only allowing one object to be instantiated. Since we are absolutely sure that we will only ever need
one of each of these objects (given in the project description) then a singleton pattern works well here. However, it does
interfere with unit testing integrity since the unit tests will need to be ordered in order to function properly.

Lastly, an Observer pattern was implemented to track the state changes of LibraryBook objects. The observers (DestObserver and
SoureObserver) are only aware of a LibraryBook objects current state, and are only notified (and then updated) when the
LibraryBook class makes a call to `Notify()`. The observer classes are then responsible for performing any actions once
notified, and can attach or deattach at any time. This means that the only responsibility for the LibraryBook class is to call
`Notify()` to alert any "interested" observers that something has happened. 


