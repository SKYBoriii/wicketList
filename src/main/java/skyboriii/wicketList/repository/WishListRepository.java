package skyboriii.wicketList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skyboriii.wicketList.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
