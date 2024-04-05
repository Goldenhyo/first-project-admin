package com.jpa4.pj1984.controller;

import com.jpa4.pj1984.domain.Book;
import com.jpa4.pj1984.domain.BookCategory;
import com.jpa4.pj1984.domain.BookCategoryStatus;
import com.jpa4.pj1984.dto.BookCategoryDTO;
import com.jpa4.pj1984.dto.BookCategoryForm;
import com.jpa4.pj1984.dto.BookDTO;
import com.jpa4.pj1984.dto.BookForm;
import com.jpa4.pj1984.service.BookCategoryService;
import com.jpa4.pj1984.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cms")
@RequiredArgsConstructor
public class BookController {
    //--공통사용-----------------------------------------------------//
    private final BookService bookService;
    private final BookCategoryService bookCategoryService;
    
//    @ModelAttribute("categoryLists")
//    public List<BookCategory> categoryLists(){
//        List<BookCategory> categoryLists = new ArrayList<>();
//        System.out.println("categoryLists = " + categoryLists);
//    }
    
    //--상품관리-----------------------------------------------------//
    
    //상품리스트
    @GetMapping("/book")
    public String bookList(){
        log.info("--CMS--Book--List--Request--");
        return "backend/book/list";
    }
    //상품추가폼
    @GetMapping("/book/add")
    public String bookAddForm(@ModelAttribute BookForm bookForm, Model model){
        log.info("--CMS--Book--AddForm--Request--");
        List<BookCategoryDTO> bookCategoryDTOList = bookCategoryService.findAll();
        System.out.println("bookCategoryDTOList = " + bookCategoryDTOList);
        System.out.println("bookForm = " + bookForm + ", model = " + model);
        return "backend/book/add";
    }
    //상품추가
    @PostMapping("/book/add")
    public String bookAddPro(BookForm bookForm){
        log.info("--CMS--Book-Add--Request--");
        Long save = bookService.save(bookForm);
        return "redirect:/cms/book";
    }

//--상품카테고리관리-----------------------------------------------------//
    
    //상품카테고리추가폼
    @GetMapping("/bookCategory/add")
    public String bookCategoryAddForm(@ModelAttribute BookCategoryForm bookCategoryForm, Model model){
        log.info("--CMS--Book--Category--AddForm--Request--");
        return "backend/bookcategory/add";
    }

    //상품카테고리추가
    @PostMapping("/bookCategory/add")
    public String bookCategoryAddPro(BookCategoryForm bookCategoryForm){
        log.info("--CMS--Book--Category--Add--Request--");
        Long save = bookCategoryService.save(bookCategoryForm);
        return "redirect:/cms/bookCategory";
    }

    //상품카테고리리스트
    @GetMapping("/bookCategory")
    public String bookCategoryList(Model model){
        log.info("--CMS--Book--Category--List--Request--");
         //DB에서 전체 게시글 데이터를 가져와서 bookCategoryList에 담아서 list.html로 전달
        List<BookCategoryDTO> bookCategoryDTOList = bookCategoryService.findAll();
        model.addAttribute("bookCategoryList", bookCategoryDTOList);
        System.out.println("bookCategoryDTOList = " + bookCategoryDTOList);
        return "backend/bookcategory/list";
    }

    //상품카테고리상세
    @GetMapping("/bookCategory/{id}")
    public String bookCategoryDetail(@PathVariable("id") Long id, Model model){
        BookCategoryDTO bookCategory = bookCategoryService.findOne(id);
        System.out.println("bookCategory = " + bookCategory);
        model.addAttribute("bookCategory", bookCategory);
        return "backend/bookcategory/detail";
    }

    //상품카테고리수정
    @GetMapping("/bookCategory/{id}/modify")
    public String bookCategoryModifyForm(@PathVariable("id") Long id, Model model){
        BookCategoryDTO bookCategory = bookCategoryService.findOne(id);
        model.addAttribute("bookCategory", bookCategory);
        return "backend/bookcategory/modify";
    }
    @PostMapping("/bookCategory/{id}/modify")
    public String bookCategoryModifyPro(@PathVariable("id") Long id, BookCategoryForm bookCategoryForm){
        bookCategoryService.updateOne(bookCategoryForm);
        return "redirect:/cms/bookCategory/{id}";
    }

}
