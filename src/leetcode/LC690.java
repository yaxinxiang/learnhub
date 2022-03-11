package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emp = new HashMap<>();
        for(Employee employee : employees){
            emp.put(employee.id, employee);
        }
        return search(id, emp);
    }

    public int search(int id, Map<Integer, Employee> map){
        Employee emp = map.get(id);
        int imp = emp.importance;
        for(Integer chId : emp.subordinates){
            imp += search(chId, map);
        }
        return imp;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};