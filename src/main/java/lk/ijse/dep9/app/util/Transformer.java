package lk.ijse.dep9.app.util;

import lk.ijse.dep9.app.dto.ProjectDTO;
import lk.ijse.dep9.app.dto.UserDTO;
import lk.ijse.dep9.app.entity.Project;
import lk.ijse.dep9.app.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Transformer {

    private ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserDTO userDTO(User user) {
        return mapper.map(user,UserDTO.class);
    }

    public User toUser(UserDTO dto) {
        return mapper.map(dto,User.class);

    }

    public Project toProject(ProjectDTO projectDTO) {
        return mapper.map(projectDTO,Project.class);
    }

    public ProjectDTO toProjectDTO(Project project) {
        return mapper.map(project, ProjectDTO.class);
    }

}
