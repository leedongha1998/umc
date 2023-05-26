package com.example.demo.src.product;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.product.model.GetProductRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 메인 페이지(상품 리스트들)
     */
    @ResponseBody
    @GetMapping
    public BaseResponse<List<GetProductRes>> productList(){

        List<GetProductRes> productList = productService.getProductList();

        return new BaseResponse<>(productList);
    }

    /**
     * 상품 등록
     */
//    @ResponseBody
//    @PostMapping("/{id}")
//    public BaseResponse<PostProductRes> insertProduct(){
//        PostProductRes productRes = productService.insertProduct();
//        return new BaseResponse<PostProductRes>(productRes);
//    }


    /**
     * 물건 검색으로 찾기
     */
    @ResponseBody
    @GetMapping("/search")
    public BaseResponse<List<GetProductRes>> findProductBySearch(@RequestParam String search){

        List<GetProductRes> productList = productService.findProductBySearch(search);

        return new BaseResponse<>(productList);
    }



}
