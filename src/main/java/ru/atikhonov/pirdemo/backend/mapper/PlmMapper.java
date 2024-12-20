package ru.atikhonov.pirdemo.backend.mapper;

import org.springframework.stereotype.Service;
import ru.atikhonov.pirdemo.backend.dto.Plm;
import ru.atikhonov.pirdemo.backend.model.PlmTreeView;
import ru.atikhonov.pirdemo.backend.util.CoreUtil;

/**
 * Маппинг:
 * -  между entity и dto rest сервиса
 */
@Service
public class PlmMapper {

    /**
     *
     * Маппинг из entity в DTO
     *
     * @param view - строка из entity
     * @return Данные в структуре DTO
     */
    public Plm fromViewToDto(PlmTreeView view) {
        Plm result = new Plm();
        CoreUtil.patch(view, result);
        return result;
    }


}
