package com.lyfebloc.token.entity;

/**
 * Created by Lyfebloc on 11/04/2019.
 * Lyfebloc
 */
public interface ParseResult
{
    enum ParseResultId
    {
        OK,
        XML_OUT_OF_DATE,
        PARSER_OUT_OF_DATE,
        PARSE_FAILED
    };

    void parseMessage(ParseResultId parseResult);
}
