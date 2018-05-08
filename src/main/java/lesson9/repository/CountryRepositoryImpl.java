package lesson9.repository;

import lesson9.domain.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryRepositoryImpl implements CountryRepository {

    private final SessionFactory factory;

    public CountryRepositoryImpl (SessionFactory factory) {
        this.factory=factory;
    }

    @Override
    public Country create(String name, String capital, double population) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Country country = new Country();
        country.setName(name);
        country.setCapital(capital);
        country.setPopulation(population);

        session.persist(country);
        transaction.commit();
        session.close();

        return country;
    }

    @Override
    public Country update(Country country) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(country);
        transaction.commit();
        session.close();

        return country;
    }

    @Override
    public void delete(Country country) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(country);
        transaction.commit();
        session.close();
    }
}
