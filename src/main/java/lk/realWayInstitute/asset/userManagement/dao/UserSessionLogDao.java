package lk.realWayInstitute.asset.userManagement.dao;

import lk.realWayInstitute.asset.userManagement.entity.Enum.UserSessionLogStatus;
import lk.realWayInstitute.asset.userManagement.entity.User;
import lk.realWayInstitute.asset.userManagement.entity.UserSessionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionLogDao extends JpaRepository<UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
