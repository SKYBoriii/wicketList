package skyboriii.wicketList.data.dao;

import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.entity.BucketList;

public interface BucketDAO {

    BucketList insertBucket(BucketList bucketList);

    BucketList selectBucket(Long id);

    BucketList updateBucketContent(Long id, String bucketContent, String bucketGoal, String completedAt) throws Exception;
    BucketList updateCompletedAt(Long id, String completedAt) throws Exception;

    void deleteBucket(Long id) throws Exception;
}
