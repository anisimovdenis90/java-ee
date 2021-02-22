package com.anisimovdenis.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Named
@ApplicationScoped
public class UserRepository {

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        this.saveOrUpdate(new User(null, "Bob", "Johnson", "bob@mail.com", LocalDate.of(1990, 12, 5), "89994443322"));
        this.saveOrUpdate(new User(null, "Den", "Dickens", "den@mail.com", LocalDate.of(1980, 10, 13), "89994333120"));
        this.saveOrUpdate(new User(null, "Carl", "Willis", "carl@mail.com", LocalDate.of(1964, 3, 21), "899955777311"));
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User findById(Long id) {
        return userMap.get(id);
    }

    public void saveOrUpdate(User user) {
        if (user.getId() == null) {
            final Long id = identity.incrementAndGet();
            user.setId(id);
        }
        userMap.put(user.getId(), user);
    }

    public void deleteById(Long id) {
        userMap.remove(id);
    }
}
