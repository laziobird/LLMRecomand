from fastapi import FastAPI
from pydantic import BaseModel
from fastapi.middleware.cors import CORSMiddleware
import gemini_pro1 as gemini_pro1
import movie_gemini_flash as flash

app = FastAPI()

# 允许所有来源，但建议在生产环境中限制来源
origins = ["*"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)


class Item(BaseModel):
    message: str


class ResultDto(BaseModel):
    code: int
    data: str
    success: bool


@app.get("/")
async def root():
    return {"message": "Hello World"}

##此API 调用Gemini Pro-1.0
@app.post("/gemini/bookRecommendation")
async def chat(item: Item):
    book_info = gemini_pro1.book_main(item.message)
    re = ResultDto(code=200, success=True, data=book_info);
    # 打印 JSON 字符串
    print(re.__dict__)
    return re


##此API 调用Gemini 最新的 1.5 Flash
@app.post("/gemini/movieRecommendation")
async def chat(item: Item):
    movie_info = flash.movie_main(item.message)
    re = ResultDto(code=200, success=True, data=movie_info);
    # 打印 JSON 字符串
    print(re.__dict__)
    return re