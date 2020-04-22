package hr.littlemouse.readingChallenge.data.mapping;

import hr.littlemouse.readingChallenge.data.dto.GoodReadsBookDTO;
import hr.littlemouse.readingChallenge.data.goodreads.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GoodReadsBookMapper {

    @Mappings({
            @Mapping(source = "bestBook.title", target = "title"),
            @Mapping(source = "bestBook.author.name", target = "author")
    })

    GoodReadsBookDTO goodReadsBookToGoodReadsBookDTO(Work work);
}
