package skyboriii.wicketList.data.dao;

import skyboriii.wicketList.entity.BucketList;

public interface BucketDAO {

    BucketList insertBucket(BucketList bucketList);

    BucketList selectBucket(Long id);

    BucketList updateBucketContent(Long id, String bucketContent) throws Exception;

    void deleteBucket(Long id) throws Exception;
}
