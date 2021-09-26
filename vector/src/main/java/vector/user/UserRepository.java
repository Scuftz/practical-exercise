package vector.user;

import org.springframework.data.repository.CrudRepository;

/**
 * This interface extends the CrudRepository which allows this class to perform CRUD operations 
 * @author Shivneel Singh
 * @since 26/09/2021
 */
public interface UserRepository extends CrudRepository<User, String> {

}
