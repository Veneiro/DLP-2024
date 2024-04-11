package ast.semantic;

import ast.program.Definition;
import ast.program.VarDefinition;
import ast.type.ErrorType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private int scope = 0;
    private List<Map<String, Definition>> table;
    public SymbolTable(){
        // Create global scope
        Map<String, Definition> global = new HashMap<String, Definition>();

        // Create Symbol Table
        this.table = new ArrayList<Map<String, Definition>>();

        // Add global scope by default
        this.table.add(global);
    }
    public void set(){
        table.add(new HashMap<>());
        this.scope++;
    }
    public void reset(){
        table.remove(scope);
        this.scope--;
    }
    public boolean insert(Definition definition){
        Definition definitionToFind = findInCurrentScope(definition.getName());
        if(definitionToFind == null) {
            table.get(scope).put(definition.getName(), definition);
            definition.setScope(scope);
            return true;
        }
        return false;
    }
    public Definition find(String id){
        for (int i = scope; i>=0; i--) {
            Definition def = table.get(i).get(id);
            if (def != null) {
                return def;
            }
        }
        return null;
    }
    public Definition findInCurrentScope(String id){
        Definition def = table.get(scope).get(id);
        return def;
    }
}
