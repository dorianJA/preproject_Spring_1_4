package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "CarName")
    private String name;

    @Column(name = "CarSeries")
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private int carId;

    public Car(String name, int series) {
        this.name = name;
        this.series = series;
    }
    public Car(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
