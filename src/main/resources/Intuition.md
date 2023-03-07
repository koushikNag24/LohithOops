### Intuition to solve Complex Inheritance Mapping



#### Steps
* Divide the Problem into small problems and isolate
* Draw the UML Class diagram to understand it clearly
    

             Base Issues       Base Health    
                  ^                 ^   
                  |                 |    
                  |                 |     
              Section G -----> Syslog Status     

* First solve Parent Child Relationship  
  * For Base Issues and Section G

        `@Inheritance(strategy = InheritanceType.JOINED)`
        `public abstract class BaseIssues {`
  * For Base Health and  Syslog status

            `@Inheritance(strategy = InheritanceType.JOINED)`
            `public class BaseHealth {`
* Solve the association between the classes Section G and Syslog status
  * In section G

          `@OneToOne(mappedBy = "sectionG",cascade = CascadeType.ALL)`
          `private  SyslogStatus syslogStatus;`
  * In Syslog Status
    
         `@OneToOne`
         `private SectionG sectionG;`

#### Tables

  base_issues
  
      base_issue_id  |   issues    
      ---------------+-------------
                   1 | Clear skies
  
  
  section_g
  
      base_issue_id
      ---------------
                    1
  
  syslog_status
  
      base_health_id  | section_g_base_issue_id
      ----------------+-------------------------
                    1 |                       1
  
  base_health
  
      base_health_id  |  name  | status
      ----------------+--------+--------
                     1| SysLog | OK



### Intuition to solve the association in parent class in multilevel inheritance

    Base Issues
         ^
         |
         |
    Base Maintenance -----> List<Station>
      ^          ^
      |          |
      |          |
      |          |  
    SectionE  SectionF


*  The association relating to Section E is completely taken care by its hierarchical parents all the way up !
*  Hence, we need not give any association mapping for it !!!
*  Here Station attribute pertaining to Section E has been taken care by Base Maintenance
*  Here Issue attribute pertaining to Section E has been taken care by Base Issue via Base Maintenance.
*  So we don't need to provide any association in Section E


  



  

