package comp.uap.it311l.passwordencryptorapi.repository;

import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PasswordMyBatisRepository {

    @Insert("insert into credentials(encryptedPassword) values(#{password})")
    public void save(String password);

    @Select("Select * from credentials where encryptedPassword = #{password}")
    public List<String> search(String password);

}
