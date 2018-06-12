package demo.service.wind;

import demo.repositories.WindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WindServiceImpl implements WindService {

    @Autowired
    private WindRepository repository;

    @Override
    public String getDirection(Double degree) {
        return repository.getDirection(degree);
    }
}
