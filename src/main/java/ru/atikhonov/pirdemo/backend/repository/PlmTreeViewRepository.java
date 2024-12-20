package ru.atikhonov.pirdemo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atikhonov.pirdemo.backend.model.PlmTreeView;


public interface PlmTreeViewRepository extends JpaRepository<PlmTreeView, Long> {
}
