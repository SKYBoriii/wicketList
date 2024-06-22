package skyboriii.wicketList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skyboriii.wicketList.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
}
