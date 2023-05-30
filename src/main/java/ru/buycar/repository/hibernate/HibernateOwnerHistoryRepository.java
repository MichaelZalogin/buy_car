package ru.buycar.repository.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.buycar.entity.HistoryOwner;
import ru.buycar.repository.BaseCrudRepository;
import ru.buycar.repository.interfaces.OwnerHistoryRepository;

@AllArgsConstructor
@Repository
public class HibernateOwnerHistoryRepository implements OwnerHistoryRepository {

    BaseCrudRepository crudRepository;

    @Override
    public HistoryOwner addOwnerHistory(HistoryOwner historyOwner) {
        return null;
    }

}