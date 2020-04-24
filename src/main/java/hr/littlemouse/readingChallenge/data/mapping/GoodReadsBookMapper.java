package hr.littlemouse.readingChallenge.data.mapping;

import hr.littlemouse.readingChallenge.data.dto.GoodReadsBookDTO;
import hr.littlemouse.readingChallenge.data.goodreads.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Mapper(componentModel = "spring", imports = LocalDate.class )
@Component
public interface GoodReadsBookMapper {

    @Mappings({
            @Mapping(target = "publicationDate", expression = "java(LocalDate.of(work.getPublicationYear(), work.getPublicationMonth(), work.getPublicationDay()))"),
            @Mapping(source = "bestBook.title", target = "title"),
            @Mapping(source = "bestBook.author.name", target = "author"),
            @Mapping(source = "bestBook.imageUrl", target = "imageUrl")
    })

    GoodReadsBookDTO goodReadsBookToGoodReadsBookDTO(Work work);
}
