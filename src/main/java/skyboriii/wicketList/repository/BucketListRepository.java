package skyboriii.wicketList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skyboriii.wicketList.entity.BucketList;

import java.util.Optional;

@Repository
public interface BucketListRepository extends JpaRepository<BucketList, Long> {

}
