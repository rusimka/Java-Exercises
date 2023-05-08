package interfaces;

@FunctionalInterface
public interface Say extends AbstractInterface1 {
    void say(String message);

    // na vakov nacin ke mozhe eden funkcioanlen interfejs da nasleduva drug interfejs koj sto ne e funkcionalen, odnosno
    // nema abstrakten metod, fakticki ima metod koj sto ima implementacija

}
