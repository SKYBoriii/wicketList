package skyboriii.wicketList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skyboriii.wicketList.entity.BucketList;

public interface BucketListRepository extends JpaRepository<BucketList, Long> {
}
