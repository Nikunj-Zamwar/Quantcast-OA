# Quantcast-OA

##Most Active Cookie

Wrote a command line program in java that given a cookie log file in the following format:  
        
*cookie,timestamp*   
*AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00*   
*SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00*    
*5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00*    
*AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00*     
*SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00*     
*4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00*     
*fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00*    
*4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00*
         
returns the most active cookie for specified day.      

For running the program, within your terminal you cd into the directory and then from there run 'java MostActiveCookie.java [filename] -d [date]'. For the purposes of this program the date is taken in the form *yyyy-mm-dd*. If not in this form there will be errors.   

There is also JUnit testing that targets 3 cases where the program may fail and 3 different form of inputs given the sample csv.
