package ru.atikhonov.pirdemo.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.atikhonov.pirdemo.backend.mapper.PlmMapper;
import ru.atikhonov.pirdemo.backend.dto.Plm;
import ru.atikhonov.pirdemo.backend.model.PlmTreeView;
import ru.atikhonov.pirdemo.backend.repository.PlmTreeViewRepository;
import ru.atikhonov.pirdemo.backend.api.PlmApiDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Класс для выполнения функций rest сервисов (GET, POST, PATCH, DELETE)
 *
 * @author Аркадий Тихонов
 */
@Service
@RequiredArgsConstructor
public class PlmApiService implements PlmApiDelegate {
    private final PlmTreeViewRepository plmTreeViewRepository;
    private final PlmMapper plmMapper;

    /**
     * Выборка дерева
     */
    @Override
    public ResponseEntity<List<Plm>> getPlmTree() {
        List<PlmTreeView> treeViewList = plmTreeViewRepository.findAll();
        ListIterator<PlmTreeView> listIterator = treeViewList.listIterator();
        Plm tree = new Plm();
        tree.setName("Справочник");
        tree.setLevel(0l);
        tree.setClassName("Корень");

        List<Plm> children = new ArrayList<>();
        Long curLevel = 1L;

        buildTree(treeViewList, listIterator, tree, null, 0l);
        List<Plm> plmList = new ArrayList<>();
        plmList.add(tree);

        return ResponseEntity.ok(plmList);
    }

    private PlmTreeView buildTree(List<PlmTreeView> treeViewList, ListIterator<PlmTreeView> listIterator, Plm nodeUp, PlmTreeView curElement, Long curLevel) {
        List<Plm> children = new ArrayList<>();
        PlmTreeView nextElement = new PlmTreeView();
        while (listIterator.hasNext()) {
            nextElement = (PlmTreeView) listIterator.next();
            if (curLevel > 0 && curElement != null && nextElement.getLevel().equals(curElement.getLevel())) {
                children.add(plmMapper.fromViewToDto(curElement));
                if (!listIterator.hasNext()) {
                    children.add(plmMapper.fromViewToDto(nextElement));
                }
            } else if (nextElement.getLevel() > curLevel) {
                Plm nodeUpNew = curElement == null ? nodeUp : plmMapper.fromViewToDto(curElement);
                nextElement = buildTree(treeViewList, listIterator, nodeUpNew, nextElement, nextElement.getLevel());
                children.add(nodeUpNew);
            } else if (nextElement.getLevel() < curLevel) {
                if (curElement != null) {
                    children.add(plmMapper.fromViewToDto(curElement));
                }
                break;
            }
            curElement = nextElement;
        }
        if (!curLevel.equals(0L)) {
            nodeUp.setChildren(children);
        }
        return nextElement;
    }
}


