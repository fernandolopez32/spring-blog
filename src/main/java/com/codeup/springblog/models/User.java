@Entity
@Table(name = "users")
public class User {
    private final Object id;
    private final Object email;
    private final Object username;
    private final Object password;

    /* ... */

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
}
