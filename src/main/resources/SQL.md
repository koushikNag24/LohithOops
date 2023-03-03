### Queries to Fetch each sections

#### SectionA
    `select bh.base_health_id, bh.name, bh.status, bh.issue, ci.section_a_id `
      `from base_health as bh `
      `join `
      `link_status as ls `
      `on bh.base_health_id=ls.base_health_id `
      `join`
      `communication_issue as ci `
      `on ls.communication_id=ci.communication_id `
      `join `
      `section_a as sa `
      `on ci.section_a_id=sa.id; `

#### SectionB
* Standard File Status

        `select sf.standard_file_id, sb.id,sf.file_name, bi.issues `
        `from base_issues as bi `
        `join `
        `section_b as sb` 
        `on bi.id=sb.id` 
        `join `
        `standard_file_status as sfs`
        `on sb.id=sfs.section_b_id `
        `join `
        `standard_file as sf `
        `on sfs.id=sf.standard_file_status_id;`

* Storage

        ` select nss.nsop_storage_status_id, nss.base_issue_id,si.section_b_id, nss.name, nss.status `
          `from nsop_storage_status as nss `
          `join`
          `storage_issues as si `
          `on nss.base_issue_id=si.id `
          `join`
          `base_issues as bi `
         ` on si.id=bi.id `
          `join `
          `section_b as sb `
          `on si.section_b_id=sb.id`

* Archival
        
        `select abc.archivals_id, abc.name, abc.status, abc.size, na.section_b_id` 
        `from archival_base_class as abc`
        `join`
       `navigation_archival as na `
        `on abc.archivals_id=na.archivals_id `
        `join`
        `section_b as sb `
        `on na.section_b_id=sb.id;`

* UERE

        `select bm.base_measurement_id, bm.location,u.chain, bm.server, u.satellite, bm.value, m.measurement_section_b `
        `from base_measurement as bm `
        `join `
        `measurement as m `
        `on bm.base_measurement_id=m.base_measurement_id `
        `join `
        `uere as u on m.base_measurement_id=u.base_measurement_id `
        `join `
        `section_b as sb on m.measurement_section_b=sb.id;`


* UserPosition

        `select bm.base_measurement_id, bm.location, bm.server, bm.value, m.measurement_section_b `
        `from base_measurement as bm `
        `join `
        `measurement as m `
        `on bm.base_measurement_id=m.base_measurement_id `
        `join `
        `user_position as up `
        `on m.base_measurement_id=up.base_measurement_id `
        `join `
        `section_b as sb `
        `on m.measurement_section_b=sb.id;`


* Issues
  
      `select bi.id, bi.issues `
      `from base_issues as bi `
      `join`
      `section_b as sb` 
      `on bi.id=sb.id;`

#### SectionC

* Parallel Chain

      `select bh.id, bh.name, bh.status,bh.issue, sc.id  `
        `from base_health as bh `
        `join `
        `parallel_chain as pc `
        `on bh.id=pc.id `
        `join `
       ` section_c as sc `
       ` on sc.id=pc.section_c_id;`

* Irnwts

      ` select bh.id, bh.name, bh.status, bh.issue, sc.id `
      `from base_health as bh `
      `join`
      `irnwt as i `
      `on bh.id=i.id `
      `join`
      `section_c as sc `
      `on i.section_c_id=sc.id;`

* Twstft Offset

      `select bv.base_valueid, bv.name, bv.value, two.issues, sc.id `
      `from base_value as bv `
      `join`
      `twstft_offset as two `
      `on bv.base_valueid=two.base_valueid `
      `join `
      `section_c as sc `
      `on sc.id=two.section_c_id;`


* Gnss Offset

      `select bv.base_valueid, bv.name, bv.value, go.issues, sc.id `
      `from base_value as bv` 
      `join`
      `gnss_offset as go `
      `on bv.base_valueid=go.base_valueid `
      `join `
      `section_c` as sc `
      `on sc.id=go.section_c_id;`

#### SectionD

* Schemacs Health
      
      `select bh.id, bh.name, bh.status,bh.issue, sh.section_d_id  `
        `from base_health as bh`
        `join`
        `schemacs_health as sh `
        `on sh.id=bh.id `
       ` join `
        `section_d as sd `
       ` on sh.section_d_id=sd.id;`

* Issues

      `select sd.id, bi.issues `
      `from section_d as sd `
        `join` 
        `base_issues as bi `
        `on bi.id=sd.id;`


#### SectionE

* IRMS

        `select * `
        `from station as s` 
        `join `
        `base_maintenance as bm `
        `on s.base_maintenance_id=bm.id `
        `join `
        `base_issues as bi `
        `on bm.id=bi.id `
        `join `
        `section_e as se `
        `on bm.id=se.id;` 

* Issues

      `select bi.id, bi.issues `
      `from section_e as se `
      `join `
      `base_issues as bi` 
      `on bi.id=se.id;`

#### SectionF

* IRCDR

       `select * `
       `from station as s`
       `join `
       `base_maintenance as bm `
       `on s.base_maintenance_id=bm.id `
       `join`
       `base_issues as bi `
       `on bm.id=bi.id`
       `join`
       `section_f as sf `
       `on bm.id=sf.id;` 

* Issues

      `select bi.id, bi.issues `
      `from section_f as sf `
      `join `
      `base_issues as bi `
      `on bi.id=sf.id;` 
  

#### Section G


* Syslog Status

      `select sg.id, bh.name, bh.status, bh.issue `
      `from base_health as bh `
      `join `
      `syslog_status as ss `
      `on bh.id= ss.id `
      `join`
      `section_g as sg `
      o`n ss.section_g_id=sg.id;`


#### SectionH

      `select sla.stn_look_angle_id, sla.available_till, sla.location, sla.base_issue_id, bi.issues `
      `from stn_look_angle as sla `
      `join `
      `section_h as sh `
      `on sh.id=sla.base_issue_id `
      `join `
      `base_issues as bi `
      `on sla.base_issue_id=bi.id;`


