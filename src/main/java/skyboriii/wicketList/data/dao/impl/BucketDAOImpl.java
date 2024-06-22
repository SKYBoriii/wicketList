package skyboriii.wicketList.data.dao.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyboriii.wicketList.data.dao.BucketDAO;
import skyboriii.wicketList.entity.BucketList;
import skyboriii.wicketList.repository.BucketListRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BucketDAOImpl implements BucketDAO {

    private final BucketListRepository bucketListRepository;

    @Autowired
    public BucketDAOImpl(BucketListRepository bucketListRepository) {
        this.bucketListRepository = bucketListRepository;
    }


    @Override
    public BucketList insertBucket(BucketList bucketList) {
        BucketList savedBucketList = bucketListRepository.save(bucketList);

        return savedBucketList;
    }

    @Override
    public BucketList selectBucket(Long id) {
        BucketList selectedBucketList = bucketListRepository.getById(id);

        return selectedBucketList;
    }

    @Override
    public BucketList updateBucketContent(Long id, String bucketContent)
            throws Exception {
        Optional<BucketList> selectedBucketList = bucketListRepository.findById(id);

        BucketList updatedBucketList;
        if (selectedBucketList.isPresent()) {
            BucketList bucketList = selectedBucketList.get();

            bucketList.setBucketContent(bucketContent);
            bucketList.setBuketUpdatedAt(LocalDateTime.now());

            updatedBucketList = bucketListRepository.save(bucketList);
        } else {
            throw new Exception();
        }

        return updatedBucketList;
    }


    @Override
    public void deleteBucket(Long id) throws Exception {
        Optional<BucketList> selectedBucketList = bucketListRepository.findById(id);

        if (selectedBucketList.isPresent()){
            BucketList bucketList = selectedBucketList.get();

            bucketListRepository.delete(bucketList);
        }
        else {
            throw new Exception();
        }
    }
}
