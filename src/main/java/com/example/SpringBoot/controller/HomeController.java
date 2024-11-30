package com.example.SpringBoot.controller;



import com.example.SpringBoot.model.AuthorModel;
import com.example.SpringBoot.model.GenreModel;
import com.example.SpringBoot.model.MusicModel;
import com.example.SpringBoot.service.AuthorService;
import com.example.SpringBoot.service.GenreService;
import com.example.SpringBoot.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {



    private final MusicService musicService;
    private final AuthorService authorService;
    private final GenreService genreService;

    @GetMapping(value = "/")
    public String indexPage(Model model,@RequestParam(name = "key", required = false,defaultValue = "") String key) {
//        List<MusicModel> musicModelList = musicRepository.findAllByDurationGreaterThanOrderByDurationDesc(0);
        model.addAttribute("muzikalar", musicService.searchMusic(key));
        return "index";
    }

    @PostMapping("/add-music")
    public String addMusic(MusicModel music) {
        musicService.addMusic(music);
        return "redirect:/";
    }



    @GetMapping(value = "/add-music")
    public String addMusicPage(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return "addmusic";
    }

    @GetMapping(value = "/details/{musicId}")
    public String musicDetails(@PathVariable(name = "musicId") Long id, Model model) {
        MusicModel music = musicService.getMusic(id);
        model.addAttribute("muzyka", music);


        List<AuthorModel> authorModelList = authorService.getAuthors();
        model.addAttribute("authors", authorModelList);

        List<GenreModel> genreModelList = genreService.getGenres();
        genreModelList.removeAll(music.getGenres());
        model.addAttribute("genres", genreModelList);

        return "details";
    }

    @PostMapping(value = "/save-music")
    public String saveMusic(MusicModel music) {
               musicService.saveMusic(music);
               return "redirect:/";
    }


    @PostMapping(value = "/delete-music")
    public String deleteMusic(@RequestParam(name = "id")Long id) {
         musicService.delete(id);
         return "redirect:/";
    }

    @PostMapping(value = "/assign-genre")
    public String assignGenre(@RequestParam(name = "music_id")Long musicId,
                              @RequestParam(name = "genre_id")Long genreId) {

            musicService.assignGenre(musicId, genreId);
            return "redirect:/details/"+musicId;


    }


    @PostMapping(value = "/unassign-genre")
    public String unassignGenre(@RequestParam(name = "music_id")Long musicId,
                              @RequestParam(name = "genre_id")Long genreId) {

        musicService.unassignGenre(musicId,genreId);
        return "redirect:/details/"+musicId;


    }

}
