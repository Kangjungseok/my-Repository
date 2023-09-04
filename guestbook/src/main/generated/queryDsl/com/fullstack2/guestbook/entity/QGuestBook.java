package generated.queryDsl.com.fullstack2.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.processing.Generated;

import com.fullstack2.guestbook.entity.GuestBook;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QGuestBook is a Querydsl query type for GuestBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuestBook extends EntityPathBase<GuestBook> {

    private static final long serialVersionUID = 583085163L;

    public static final QGuestBook guestBook = new QGuestBook("guestBook");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> gno = createNumber("gno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regdate = _super.regdate;

    public final StringPath subject = createString("subject");

    public final StringPath writer = createString("writer");

    public QGuestBook(String variable) {
        super(GuestBook.class, forVariable(variable));
    }

    public QGuestBook(Path<? extends GuestBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuestBook(PathMetadata metadata) {
        super(GuestBook.class, metadata);
    }

}

