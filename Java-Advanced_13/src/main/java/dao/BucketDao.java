package dao;

import domain.Bucket;
import shared.AbstractCRUD;

public interface BucketDao extends AbstractCRUD<Bucket> {
    Bucket read(String id);
}
