package com.example.crud.repository;

import com.example.crud.dto.StudyGroupFilter;
import com.example.crud.model.QStudyGroup;
import com.example.crud.model.StudyGroup;
import com.example.crud.util.sort.Page;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudyGroupRepository extends SimpleJpaRepository<StudyGroup, Long> {
    private final JPAQueryFactory factory;
    private final Querydsl querydsl;

    public StudyGroupRepository(EntityManager entityManager) {
        super(StudyGroup.class, entityManager);
        this.factory = new JPAQueryFactory(entityManager);
        this.querydsl = new Querydsl(entityManager,
                new PathBuilder<>(StudyGroup.class, "studyGroup"));
    }

    public Page<StudyGroup> findAllByPredicate(StudyGroupFilter filter, Pageable pageable) {
        QStudyGroup studyGroup = QStudyGroup.studyGroup;

        JPQLQuery<StudyGroup> query = factory.select(studyGroup)
                .from(studyGroup)
                .where(getPredicate(studyGroup, filter))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        JPQLQuery<Long> querySize = factory.select(studyGroup.count())
                .from(studyGroup)
                .where(getPredicate(studyGroup, filter));



        query = querydsl.applySorting(pageable.getSort(), query);
        Page<StudyGroup> page = new Page<>();

        page.setData(query.fetch());
        page.setTotalSize(querySize.fetchOne());

        return page;
    }

    private Predicate getPredicate(QStudyGroup studyGroup, StudyGroupFilter filter) {
        BooleanExpression namePredicate = null;
        if (filter.getName() != null) {
            namePredicate = studyGroup.name.eq(filter.getName() );
        }

        BooleanExpression coordinateXPredicate = null;
        if (filter.getCoordinatesX() != null) {
            coordinateXPredicate = studyGroup.coordinates.x.eq(filter.getCoordinatesX());
        }

        BooleanExpression coordinateYPredicate = null;
        if (filter.getCoordinatesY() != null) {
            coordinateYPredicate = studyGroup.coordinates.y.eq(filter.getCoordinatesY());
        }

        BooleanExpression creationDatePredicate = null;
        if (filter.getCreationDate() != null) {
            creationDatePredicate = studyGroup.creationDate.eq(filter.getCreationDate());
        }

        BooleanExpression studentsCountPredicate = null;
        if (filter.getStudentsCount() != null) {
            studentsCountPredicate = studyGroup.studentsCount.eq(filter.getStudentsCount());
        }

        BooleanExpression shouldBeExpelledPredicate = null;
        if (filter.getShouldBeExpelled() != null) {
            shouldBeExpelledPredicate = studyGroup.shouldBeExpelled.eq(filter.getShouldBeExpelled());
        }

        BooleanExpression formOfEducationPredicate = null;
        if (filter.getFormOfEducation() != null) {
            formOfEducationPredicate = studyGroup.formOfEducation.eq(filter.getFormOfEducation());
        }

        BooleanExpression semesterEnumPredicate = null;
        if (filter.getSemesterEnum() != null) {
            semesterEnumPredicate = studyGroup.semesterEnum.eq(filter.getSemesterEnum());
        }

        BooleanExpression groupAdminPassportIDPredicate = null;
        if (filter.getGroupAdminPassportID() != null) {
            groupAdminPassportIDPredicate = studyGroup.groupAdmin.passportID.eq(filter.getGroupAdminPassportID());
        }

        return ExpressionUtils.allOf(namePredicate, coordinateXPredicate, coordinateYPredicate, creationDatePredicate,
                studentsCountPredicate, shouldBeExpelledPredicate, formOfEducationPredicate, semesterEnumPredicate,
                groupAdminPassportIDPredicate);
    }
}
