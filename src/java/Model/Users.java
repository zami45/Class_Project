
package Model;

public class Users {
    private int Id;
    private String username;
    
    public Users(){
        
       
    }
    
    public Users(int Id,String name){
        
        this.Id = Id;
        this.username = name;
    }
    
    public void SetId(int id){
        this.Id = id;
    }
    
    public void SetName(String name){
        this.username = name;
    }
    public int getId(){
        return this.Id;
    }
    
    public String getName(){
        return this.username;
    }
}
