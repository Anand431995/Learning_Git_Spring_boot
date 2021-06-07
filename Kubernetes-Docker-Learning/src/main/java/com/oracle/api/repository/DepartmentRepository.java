package com.oracle.api.repository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.oracle.api.dtos.DepartmentDto;
import com.oracle.api.dtos.EmployeeDto;
import com.oracle.api.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {
  
 // @Query(value="select * from Department where dept_loc=?2 and  NOT dept_name=?1",nativeQuery = true)
  //public List<Department> findByEmployeeCount(String id,String location);
  List<Department> findByNameAndLocNot(String id,String location);
  
  /*@Query("SELECT " +
      "    new com.oracle.api.dtos.EmployeeDto(v.loc, COUNT(v)) " +
      "FROM " +
      "    Department v " + " where NOT v.name IN :names " +
      "GROUP BY " +
      "    v.loc")
  List<EmployeeDto> getsampledata(@Param("names") List<String> name); */
  
 /* @Query("SELECT " +
      "    new com.oracle.api.dtos.EmployeeDto(v.loc, COUNT(v)) " +
      "FROM " +
      "    Department v " + " where v.name IN :names " +" AND v.lastUpdateDate > :newname "+
      "GROUP BY " +
      "    v.loc")*/
  //@Query(value="SELECT e from Department e where e.name in :names and e.lastUpdateDate > :newname ")
 // @Query(value = "select "+"new com.oracle.api.dtos.DepartmentDto(cast(c.lastUpdateDate as date),COUNT(c.lastUpdateDate) as count) "+ "from  Department c "+" where c.name IN :names " +" AND c.lastUpdateDate > :newname " +"GROUP BY cast(c.lastUpdateDate as date)")
  
  /*@Query(value = "SELECT " + " new com.oracle.api.dtos.DepartmentDto"
      + "(FUNCTION('TO_CHAR', v.lastUpdateDate,'YYYY-MM'), count(1)) "
      + " FROM Department v where v.name IN :statusList and v.lastUpdateDate > :interval "
      + "GROUP BY FUNCTION('TO_CHAR', v.lastUpdateDate,'YYYY-MM')") */
  
  /*@Query(value = "SELECT " + " new com.oracle.api.dtos.DepartmentDto"
      + "(v.lastUpdateDate,COUNT(v)) " + "FROM " + "    Department v " + " where  v.name IN :statusList "
      + " and v.lastUpdateDate > :interval " + "GROUP BY " + "    v.lastUpdateDate") */
  @Query(value="SELECT e from Department e where e.name in :statusList and e.lastUpdateDate > :interval ")
  List<Department> getsampledata(@Param("statusList") List<String> StatusList ,@Param("interval") Instant Interval);
  
  /*@Query(value = "select "+"new com.oracle.api.dtos.DepartmentDto(to_char(v.lastUpdateDate, 'YYYY-MON-DD'), COUNT(v)) "+ "from Department v "
      + " where v.name IN :names " + "and v.last_update_date > :newname"+ "group by to_char(to_char(v.lastUpdateDate, 'YYYY-MON-DD')")*/
  //@Query("select to_char(last_update_date, 'YYYY-MON-DD') , count(*) from oaloks.OKSIB_INT_OCM_EVENT where PROCESSING_STATUS in ('OCM_OIH_REQ_SUCCESS','OCM_OIH_REQ_SUCCESS') and last_update_date > SYSDATE-10 group by to_char(last_update_date, 'YYYY-MON-DD'"))
  //@Query("select new DBClass(COUNT(Department.lastUpdateDate) as count,cast(c.lastUpdateDate as date)) from Table Department GROUP BY cast(Department.lastUpdateDate as date)")
  /*@Query(value = "SELECT "
      + " new oal.oracle.apps.iboks.integ.application.dashboard.ocm.dtos.OcmEventForProcessingTwoDto(OPERATOR('ToChar', v.lastUpdateDate,'YYYY-MM-DD'), COUNT(v)) "
      + " FROM OcmEvent v where v.processingStatus IN :statusList and v.lastUpdateDate < :interval GROUP BY OPERATOR('ToChar', v.lastUpdateDate,'YYYY-MM-DD')")
  List<DepartmentDto> getsampledata1(@Param("statusList") List<CreditCheckStatus> statusList,
      @Param("interval") Instant interval); */
  /*@Query(value ="SELECT count(ac) as count, function('date_format',, '%Y, %m, %d') as date FROM MyTable ac "+ 
      "WHERE ac.subscriptionStartDate BETWEEN :startDate AND :endDate GROUP BY function('date_format', ac.subscriptionStartDate, '%Y, %m, %d')") */
  
  //@Query(value = "select "+"new com.oracle.api.dtos.DepartmentDto(cast(c.lastUpdateDate as date),COUNT(c.lastUpdateDate) as count) "+ "from  Department c "+" where c.name IN :names " +" AND c.lastUpdateDate > :newname " +"GROUP BY function('date_format',c.lastUpdateDate, '%Y, %m, %d')")
  //@Query(value = "select "+"new com.oracle.api.dtos.DepartmentDto(DATE_FORMAT(c.lastUpdateDate,'%Y-%m'),COUNT(c.lastUpdateDate) as count) "+ "from  Department c "+" where c.name IN :names " +" AND c.lastUpdateDate > :newname " +"GROUP BY DATE_FORMAT(c.lastUpdateDate,'%Y-%m')")
 // @Query(value = "SELECT " + " new oal.oracle.apps.iboks.integ.application.dashboard.ocm.dtos.OcmDto"
  //    + "(FUNCTION('TO_CHAR', v.lastUpdateDate,'YYYY-MM-DD'), count(1)) "
 //     + " FROM OcmEvent v where v.processingStatus IN :statusList and v.lastUpdateDate > :interval "
 //     + "GROUP BY FUNCTION('TO_CHAR', v.lastUpdateDate,'YYYY-MM-DD')")
  //List<DepartmentDto> getsampledata1(@Param("names") List<String> name ,@Param("newname") Instant newname); 
  
}
