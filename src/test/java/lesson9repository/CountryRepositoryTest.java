package lesson9repository;

import lesson9.domain.Country;
import lesson9.repository.CountryRepository;
import lesson9.repository.CountryRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CountryRepositoryTest {

    //Mock

    private CountryRepository repository;
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    @Before
    public void setup() {
        factory = mock(SessionFactory.class);
//        System.out.println(factory.getClass().getName());
        session = mock(Session.class);
        transaction = mock(Transaction.class);
//        System.out.println(factory.openSession());
//        System.out.println(session);

        repository = new CountryRepositoryImpl(factory);

        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);

    }

    @Test
    public void testCreate_validData_returnSavedObject() {
        String name = "Russia";
        String capital = "Moscow";
        Double population = 170_000_000d;

        Country country = repository.create(name, capital, population);
        assertEquals(name, country.getName());
        assertEquals(capital, country.getCapital());
        assertEquals(population, country.getPopulation(), 0.0d); //третий параметр-погрешность, на сколько могут отличаться значения

        //в persist параметры либо оба матчеры, либо оба реальные объекты
        verify(session, times(1)).persist(Matchers.any(Country.class)); //session.persist было вызван 1 раз (по умолчанию также) c объектом типа Country.class
        verify(transaction, times(1)).commit();
        verify(session).close();
    }

    @Test
    public void testUpdate_returnUpdatedObject() {
        String name = "Russia";
        String capital = "Moscow";
        Double population = 170_000_000d;

        String nameNew = "Russian Federation";
        String capitalNew = "Moscow city";
        Double populationNew = 171_000_000d;

        Country country = repository.create(name, capital, population);
        country.setName(nameNew);
        country.setCapital(capitalNew);
        country.setPopulation(populationNew);
        Country countryNew = repository.update(country);

        assertEquals(nameNew, countryNew.getName());
        assertEquals(capitalNew, countryNew.getCapital());
        assertEquals(populationNew, countryNew.getPopulation(), 0.0d);

        verify(session, times(1)).merge(Matchers.any(Country.class));
        verify(transaction, times(2)).commit();
        verify(session, times(2)).close();
    }

    @Test
    public void testDelete() {
        String name = "Russia";
        String capital = "Moscow";
        Double population = 170_000_000d;
        int id;

        Country country = repository.create(name, capital, population);
        id = country.getId();
        repository.delete(country);
        assertTrue(session.get(Country.class,id) == null);

        verify(session, times(1)).delete(Matchers.any(Country.class));
        verify(transaction, times(2)).commit();
        verify(session, times(2)).close();
    }

}
