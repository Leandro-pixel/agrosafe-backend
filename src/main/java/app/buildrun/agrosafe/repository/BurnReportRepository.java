package app.buildrun.agrosafe.repository;
import org.springframework.stereotype.Repository;

import app.buildrun.agrosafe.entity.BurnReport;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BurnReportRepository extends JpaRepository<BurnReport, UUID> {
    List<BurnReport> findByUserId(UUID userId);
}
