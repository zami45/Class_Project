/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author shimantta
 */
public class Users {
    private int Id;
    private String name;
    
    public Users(){
        
        
    }
    
    public Users(int Id,String name){
        
        this.Id = Id;
        this.name = name;
    }
    
    public void SetId(int id){
        this.Id = id;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public int getId(){
        
        return this.Id;
    }
    
    public String getName(){
        return this.name;
    }
}
